package com.example.AssetManagement.model;

import java.util.List;
public interface AssetService {
    List<Asset> getAllAssets();
    Asset getAssetById(Long id);
    Asset addAsset(Asset asset);
    Asset updateAsset(Long id, Asset assetDetails);
    void deleteAsset(Long id);
    List<Asset> searchAssetsByName(String name);
    Asset assignAsset(Long assetId, Long employeeId);
    Asset recoverAsset(Long assetId);
}