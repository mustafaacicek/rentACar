package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service // this class is a Business object
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;

	public BrandManager(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponses = new ArrayList<>();
		for (Brand brand: brands){
			GetAllBrandsResponse brandsResponseItem = new GetAllBrandsResponse();
			brandsResponseItem.setId(brand.getId());
			brandsResponseItem.setName(brand.getName());
			brandsResponses.add(brandsResponseItem);
		}
		return brandsResponses;
	}
	@Override
	public void add(CreateBrandRequest createBrandRequest){

		Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());

		this.brandRepository.save(brand);
	}

}
