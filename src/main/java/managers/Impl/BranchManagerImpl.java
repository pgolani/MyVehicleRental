package managers.Impl;

import entities.Branch;
import lombok.AllArgsConstructor;
import managers.BranchManager;
import repo.Repo;
@AllArgsConstructor
public class BranchManagerImpl implements BranchManager {

    Repo repo;

    @Override
    public Branch getBranch(String id) {
        if(repo.branchRepo.containsKey(id)){
            return repo.branchRepo.get(id);
        }
        else
            return null;
    }

    @Override
    public boolean addBranch(Branch branch) {
            if(repo.branchRepo.containsKey(branch.getBranchId())){
                return false;
            }
            else
            {
                repo.branchRepo.put(branch.getBranchId(), branch);
                return true;
            }
    }

    @Override
    public boolean deleteBranch(Branch branch) {
        return false;
    }
}
