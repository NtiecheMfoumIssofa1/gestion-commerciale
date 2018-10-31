package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Stock;
import org.springframework.data.domain.Page;

public interface StockMetier {
	public Stock saveStock(Stock s);
	public Stock updateStock(Long idStock,Stock s);
	public boolean deleteStock(Long idStatut);
	public Stock getStock(Long idStock);
	public List<Stock> getAllStock();
	public Page<Stock> getParMc(String mc,int page,int size);
}
