package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.StockRepository;
import org.gescom.entities.Stock;
import org.gescom.metier.StockMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class StockMetierimpl implements StockMetier{
	@Autowired
	private StockRepository stockRepository;
	@Override
	public Stock saveStock(Stock s) {
		// TODO Auto-generated method stub
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Long idStock, Stock s) {
		s.setRefStock(idStock);
		return stockRepository.save(s);
	}

	@Override
	public boolean deleteStock(Long id) {
		if(getStock(id)!=null)return true;
		else return false;
	}

	@Override
	public Stock getStock(Long idStock) {
		// TODO Auto-generated method stub
		return stockRepository.getOne(idStock);
	}

	@Override
	public List<Stock> getAllStock() {
		// TODO Auto-generated method stub
		return stockRepository.findAll();
	}

	@Override
	public Page<Stock> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
