package com.emergentes.dao;

import com.emergentes.modelo.Seminario;
import com.emergentes.utiles.ConexionBD;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAOimpl extends ConexionBD implements AvisoDAO{

    @Override
    public void insert(Seminario sem) throws Exception {
        try {
            this.conectar();
            String sql="insert into seminarios (titulo,expositor,fecha,hora,cupo) values (?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1, sem.getTitulo());
            ps.setString(2, sem.getExpositor());
            ps.setString(3, sem.getFecha());
            ps.setString(4, sem.getHora());
            ps.setInt(5, sem.getCupo());
            
            //ejecutamos la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Seminario sem) throws Exception {
        try {
            this.conectar();
            String sql="update seminarios set titulo=?,expositor=?,fecha=?,hora=?,cupo=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1, sem.getTitulo());
            ps.setString(2, sem.getExpositor());
            ps.setString(3, sem.getFecha());
            ps.setString(4, sem.getHora());
            ps.setInt(5, sem.getCupo());
            ps.setInt(6, sem.getId());            
            //ejecutamos la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql="delete from seminarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);            
            ps.setInt(1, id);            
            //ejecutamos la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Seminario getById(int id) throws Exception {
        Seminario sem = new Seminario();
        try {
            this.conectar();
            String sql="select * from seminarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql); 
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()){
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setExpositor(rs.getString("expositor"));
                sem.setFecha(rs.getString("fecha"));
                sem.setHora(rs.getString("hora"));
                sem.setCupo(rs.getInt("cupo"));
            }
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
        return sem;
    }

    @Override
    public List<Seminario> getAll() throws Exception {
       List<Seminario> lista = null;
        try {
            this.conectar();
            String sql="select * from seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql); 
            ResultSet rs= ps.executeQuery();
            lista = new ArrayList<Seminario>();
            
            while(rs.next()){
                Seminario sem = new Seminario();
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setExpositor(rs.getString("expositor"));
                sem.setFecha(rs.getString("fecha"));
                sem.setHora(rs.getString("hora"));
                sem.setCupo(rs.getInt("cupo"));
                
                lista.add(sem);
            }
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
