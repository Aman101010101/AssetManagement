package com.example.AssetManagement.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @GetMapping("/{id}")
    public Asset getAssetById(@PathVariable Long id) {
        return assetService.getAssetById(id);
    }

    @PostMapping
    public Asset addAsset(@RequestBody Asset asset) {
        return assetService.addAsset(asset);
    }

    @PutMapping("/{id}")
    public Asset updateAsset(@PathVariable Long id, @RequestBody Asset assetDetails) {
        return assetService.updateAsset(id, assetDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public List<Asset> searchAssetsByName(@RequestParam String name) {
        return assetService.searchAssetsByName(name);
    }

    @PutMapping("/{assetId}/assign/{employeeId}")
    public Asset assignAsset(@PathVariable Long assetId, @PathVariable Long employeeId) {
        return assetService.assignAsset(assetId, employeeId);
    }

    @PutMapping("/{assetId}/recover")
    public Asset recoverAsset(@PathVariable Long assetId) {
        return assetService.recoverAsset(assetId);
    }
}
