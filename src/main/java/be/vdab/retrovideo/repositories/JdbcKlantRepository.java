package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Klant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcKlantRepository implements KlantRepository
{

    private final JdbcTemplate template;

    private final RowMapper<Klant> klantMapper = (result, rowNum) ->
            new Klant(result.getInt("id"),
                    result.getString("familienaam"),
                    result.getString("voornaam"),
                    result.getString("straatNummer"),
                    result.getString("postcode"),
                    result.getString("gemeente"));

    //CONSTRUCTORS
    public JdbcKlantRepository(JdbcTemplate template)
    {
        this.template = template;
    }


    //METHODS
    @Override
    public List<Klant> getKlantByFamilieNaam(String familienaam) {
        String sql = "select * from klanten where familienaam LIKE ('%" + familienaam + "%') order by voornaam";
        return template.query(sql, klantMapper);
    }
}
