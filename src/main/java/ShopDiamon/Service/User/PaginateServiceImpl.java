package ShopDiamon.Service.User;

import org.springframework.stereotype.Service;

import ShopDiamon.Dto.PaginateDTO;
@Service
public class PaginateServiceImpl implements IPaginateService{
	
	public PaginateDTO getInfoPaginate(int totalData, int limit, int currentPage) {		
		PaginateDTO paginateDTO = new PaginateDTO();
		paginateDTO.setLimit(limit);
		paginateDTO.setTotalPage(setInfoTotalPage(totalData, limit));	
		paginateDTO.setCurrentPage(checkCurrentPage(currentPage, paginateDTO.getTotalPage()));
		int start = findPaginate(paginateDTO.getCurrentPage(), limit);
		paginateDTO.setStart(start);
		int end = findEnd(paginateDTO.getStart(), limit, totalData);
		paginateDTO.setEnd(end);
		return paginateDTO;
	}
	private int findEnd(int start, int limit, int totalData) {				
		return (start + limit) > totalData ? totalData : (start + limit) -1;
	}
	private int findPaginate(int currentPage, int limit) {

		return ((currentPage-1)*limit ) + 1;
	}

	private int setInfoTotalPage(int totalData, int limit) {
		int totalPage=0;
		totalPage = totalData/limit;
		totalPage = (totalPage*limit) < totalData ? (totalPage+ 1) : totalPage;
		return totalPage;
	}
	//kiem tra trang hien tai dang nhan vao
	public int checkCurrentPage(int currentPage, int totalPage) {
		if( currentPage < 1 ) {
			return 1;
		}
		if( currentPage > totalPage) {
			return totalPage;
		}
		return totalPage;
				
		
	}
}
