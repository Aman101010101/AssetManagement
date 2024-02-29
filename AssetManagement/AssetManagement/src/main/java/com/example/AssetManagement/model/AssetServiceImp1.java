package com.example.AssetManagement.model;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImp1 implements AssetService{
    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset getAssetById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset", "id", id));
    }

    @Override
    public Asset addAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    @Override
    public Asset updateAsset(Long id, Asset assetDetails) {
        Asset asset = getAssetById(id);
        asset.setName(assetDetails.getName());
        asset.setPurchaseDate(assetDetails.getPurchaseDate());
        asset.setConditionNotes(assetDetails.getConditionNotes());
        asset.setAssignmentStatus(assetDetails.getAssignmentStatus());
        asset.setCategory(assetDetails.getCategory());
        return assetRepository.save(asset);
    }

    @Override
    public void deleteAsset(Long id) {
        Asset asset = getAssetById(id);
        if (asset.getAssignmentStatus() == AssetStatus.ASSIGNED) {
            throw new BadRequestException("Cannot delete an assigned asset");
        }
        assetRepository.delete(asset);
    }

    @Override
    public List<Asset> searchAssetsByName(String name) {
        return assetRepository.findByNameContaining(name);
    }

    @Override
    public Asset assignAsset(Long assetId, Long employeeId) {
        Asset asset = getAssetById(assetId);
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
        asset.setAssignmentStatus(AssetStatus.ASSIGNED);
        asset.setAssignedTo(employee);
        return assetRepository.save(asset);
    }

    @Override
    public Asset recoverAsset(Long assetId) {
        Asset asset = getAssetById(assetId);
        asset.setAssignmentStatus(AssetStatus.RECOVERED);
        asset.setAssignedTo(null);
        return assetRepository.save(asset);
    }
}
