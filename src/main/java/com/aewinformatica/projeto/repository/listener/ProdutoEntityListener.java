package com.aewinformatica.projeto.repository.listener;

import javax.persistence.PostLoad;

import org.springframework.stereotype.Component;

import com.aewinformatica.projeto.model.Produto;
import com.aewinformatica.projeto.storage.FotoStorage;

@Component
public class ProdutoEntityListener {

	@PostLoad
	public void postLoad(final Produto produto){
	
		produto.setUrlFoto(FotoStorage.URL + produto.getFotoOuMock());
		produto.setUrlThumbnailFoto(FotoStorage.URL + FotoStorage.THUMBNAIL_PREFIX + produto.getFotoOuMock());
	}
}
