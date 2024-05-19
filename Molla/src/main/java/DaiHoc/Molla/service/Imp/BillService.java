package DaiHoc.Molla.service.Imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Bill;
import DaiHoc.Molla.entity.MonthlyRevenue;
import DaiHoc.Molla.repository.BillRepository;
import DaiHoc.Molla.service.IBillService;

@Service
public class BillService implements IBillService{

	@Autowired
	private BillRepository repo;
	@Override
	public List<Bill> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Boolean save(Bill account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Bill account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Bill> findBillByUserId(Long userId) {
		// TODO Auto-generated method stub
		return repo.findBillByUserId(userId);
	}

	@Override
	public float TotalRevenueBetweenDates(Date startDate, Date endDate) {
	
		Float totalRevenue = repo.findTotalRevenueBetweenDates(startDate, endDate);
        return totalRevenue != null ? totalRevenue : 0.0f;
	}
	


  

	@Override
	 public List<MonthlyRevenue> calculateMonthlyRevenue() {
        List<Object[]> results = repo.getMonthlyRevenue();
        List<MonthlyRevenue> monthlyRevenueList = new ArrayList<>();

        
        for (int month = 1; month <= 12; month++) {
            boolean found = false;

            for (Object[] result : results) {
                if (month ==(int) result[1]) {
                	int year = (int) result[0];
                     month = (int) result[1];
                    double revenue = (double) result[2];
                    monthlyRevenueList.add(new MonthlyRevenue(year, month, revenue));
                    found = true;
                    break;
                }
            }
            
            if (!found) {
            	 int year = 2024;
            	 double revenue =0.0f;
            	 monthlyRevenueList.add(new MonthlyRevenue(year, month, revenue));
            }
        }

        return monthlyRevenueList;
    }

	 


}
