package ShopDiamon.Service.User;

import org.springframework.stereotype.Service;

import ShopDiamon.Dto.PaginateDTO;

@Service
public interface IPaginateService {
	public PaginateDTO getInfoPaginate(int totalData, int limit, int currentPage);

}
