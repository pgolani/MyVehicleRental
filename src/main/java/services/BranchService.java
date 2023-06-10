package services;

import dto.BranchDTO;
import entities.Branch;

public interface BranchService {

    public boolean onboardBranch(BranchDTO branchDTO);

    public Branch getBranch(String id);

    public boolean discardBranch(String id);
}
