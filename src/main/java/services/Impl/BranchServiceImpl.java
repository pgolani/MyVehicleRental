package services.Impl;

import dto.BranchDTO;
import entities.Branch;
import lombok.AllArgsConstructor;
import managers.BranchManager;
import repo.Repo;
import services.BranchService;
@AllArgsConstructor
public class BranchServiceImpl implements BranchService {

    Repo repo;
    BranchManager branchManager;

    @Override
    public boolean onboardBranch(BranchDTO branchDTO) {
        Branch branch= new Branch(branchDTO.getId() , branchDTO.getVehicletype());
        return branchManager.addBranch(branch);
    }

    @Override
    public Branch getBranch(String id) {
        if(repo.branchRepo.containsKey(id)){
            return repo.branchRepo.get(id);
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public boolean discardBranch(String id) {
        return false;
    }
}
