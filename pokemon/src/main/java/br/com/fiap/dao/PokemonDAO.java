package br.com.fiap.dao;

import br.com.fiap.to.PokemonTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PokemonDAO {
    public ArrayList<PokemonTO> findAll() {
        ArrayList<PokemonTO> pokemons = new ArrayList<>();
        PokemonTO pokemon = new PokemonTO(1L, "Charmander", 2.50, 5.0, "Fogo", LocalDate.parse("2025-02-10"));
        pokemons.add(pokemon);
        pokemon = new PokemonTO(2L, "Squirtle", 2.60, 6.0, "Água", LocalDate.now());
        pokemons.add(pokemon);
        pokemon = new PokemonTO(3L, "Bulbasaur", 5.00, 15.00, "Planta", LocalDate.now().plusYears(2));
        pokemons.add(pokemon);
        return pokemons;
    }

    public PokemonTO save(PokemonTO pokemon) {
        String sql = "insert into ddd_pokemons(nome, altura, peso, categoria, data_da_captura) values (?,?,?,?,?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setString(1, pokemon.getNome());
            ps.setDouble(2, pokemon.getAltura());
            ps.setDouble(3, pokemon.getPeso());
            ps.setString(4, pokemon.getCategoria());
            ps.setDate(5, Date.valueOf(pokemon.getDataDaCaptura()));
            if (ps.executeUpdate() > 0) {
                return pokemon;
            } else  {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
