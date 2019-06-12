package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreRepository implements GenreRepository
{
    private final JdbcTemplate template;

    private final RowMapper<Genre> genreMapper = (result, rowNum) ->
            new Genre(result.getInt("id"), result.getString("naam"));

    //CONSTRUCTORS
    JdbcGenreRepository(JdbcTemplate template)
    {
        this.template = template;
    }

    //METHODS
    @Override
    public List<Genre> findAll()
    {
        String sql = "select id, naam from genres order by naam";
        return template.query(sql, genreMapper);
    }
}
