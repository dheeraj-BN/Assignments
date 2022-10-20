package com.valtech.tx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.tx.entity.Tx;
import com.valtech.tx.repository.TxRepository;

@Service
public class TxServiceImpl implements TxService {
	
	@Autowired
	private TxRepository txRepo;
	
	@Override
    public Tx newTx(Tx tx){
        return txRepo.save(tx);
    }
    
    @Override
    public Tx getTx(long id){
        return txRepo.findById(id).get();
    }
    
    @Override
    public List<Tx> getAllTx(){
        return txRepo.findAll();
    }



   @Override
    public Tx createNewTx(float amount, boolean debit, long accountId){
        Tx tx1 = new Tx(amount, debit, accountId);
        return tx1;
    }



   @Override
    public Tx newDebitTx(float amount, long accountId) {
        // TODO Auto-generated method stub
        Tx tx1 = new Tx(amount, true, accountId);
        return tx1;
    }
    
    @Override
    public Tx newCreditTx(float amount, long accountId) {
        // TODO Auto-generated method stub
        Tx tx1 = new Tx(amount, false, accountId);
        return tx1;
    }

}
