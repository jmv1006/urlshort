package com.github.jmv1006.urlshort.urlsaves;

import com.github.jmv1006.urlshort.core.CoreDBModel;
import com.github.jmv1006.urlshort.core.CoreRepository;
import com.github.jmv1006.urlshort.urlsaves.apimodels.CreateUrlSaveRequest;
import com.github.jmv1006.urlshort.user.UserModel;
import com.github.jmv1006.urlshort.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlSaveService {
    public final UrlSaveRepository urlSaveRepo;
    public final UserRepository userRepo;

    public final CoreRepository mainRepo;

    public UrlSaveService(UrlSaveRepository urlSaveRepo, UserRepository userRepo, CoreRepository mainRepo) {
        this.urlSaveRepo = urlSaveRepo;
        this.userRepo = userRepo;
        this.mainRepo = mainRepo;
    }

    public Optional<UrlSaveModel> getUrlSave(String urlSaveId) {
        return urlSaveRepo.findById(urlSaveId);
    }

    public UrlSaveModel[] getUserSaves(String userId) {
        return urlSaveRepo.findByUserId(userId);
    }

    public void deleteUrlSave(String urlSaveId) {
        urlSaveRepo.deleteById(urlSaveId);
    }

    public UrlSaveModel createUrlSave(CreateUrlSaveRequest request) {
        String userId = request.userId;
        String urlId = request.urlId;

        // verifying user exists
        Optional<UserModel> userOp = userRepo.findById(userId);

        if(userOp.isEmpty()) return null;

        // verifying url exists in db
        Optional<CoreDBModel> urlDocumentOp = mainRepo.findById(urlId);

        if(urlDocumentOp.isEmpty()) return null;

        // create new url save and return it
        return urlSaveRepo.save(new UrlSaveModel(userOp.get().id, urlDocumentOp.get()));
    }
}
