package com.company.service.user_principal;

import com.company.model.User;
import com.company.model.UserPrincipal;
import com.company.service.IServiceGeneric;

public interface IUserPrincipal extends IServiceGeneric<UserPrincipal> {
    User getCurrentUser();
}
