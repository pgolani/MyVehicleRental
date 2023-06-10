package managers;

import entities.Branch;

public interface BranchManager {

    public Branch getBranch(String id);

    public boolean addBranch(Branch branch);
    public boolean deleteBranch(Branch branch);
}
