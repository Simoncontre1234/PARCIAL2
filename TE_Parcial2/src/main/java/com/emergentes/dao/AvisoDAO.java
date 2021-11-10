package com.emergentes.dao;

import com.emergentes.modelo.Seminario;
import java.util.List;

public interface AvisoDAO {
    public void insert(Seminario ev)throws Exception;
    public void update(Seminario ev)throws Exception;
    public void delete(int id)throws Exception;
    public Seminario getById(int id)throws Exception;    
    public List<Seminario> getAll()throws Exception;   
}
