package br.ufpb.dcx.apps4society.educapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpb.dcx.apps4society.educapi.domain.Context;
import br.ufpb.dcx.apps4society.educapi.repositories.ContextRepository;
import br.ufpb.dcx.apps4society.educapi.services.exceptions.ObjectNotFoundException;

@Service
public class ContextService {
	@Autowired
	private ContextRepository contextRepository;
	
	public Context search(Long id) throws ObjectNotFoundException {
		Optional<Context> obgOptional = contextRepository.findById(id);
		return obgOptional.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Context.class.getName()));
	}

}