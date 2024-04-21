package dao;

import java.util.ArrayList;

import entity.Xuong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public interface Xuong_DAO {
	public ArrayList<Xuong> getDSXuong();	
	public Xuong getMotXuong(String maXuong);
	public ArrayList<Xuong> layTatCaXuongKhacNhau();
}
