package br.com.fiap.bo;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.to.PokemonTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class PokemonBO {
    private PokemonDAO pokemonDAO;
    public ArrayList<PokemonTO> findAll(){
        pokemonDAO = new PokemonDAO();
        // aqui se implementa as regas de negócios
        return pokemonDAO.findAll();
    }

    public PokemonTO save(PokemonTO pokemon) {
        pokemonDAO = new PokemonDAO();
        if (pokemon.getDataDaCaptura().isAfter(LocalDate.now().plusDays(1))) {
            return null;
        }
        return pokemonDAO.save(pokemon);
    }
}