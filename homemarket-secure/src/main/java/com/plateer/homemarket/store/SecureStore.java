package com.plateer.homemarket.store;

import com.plateer.homemarket.entity.CustomUser;

public interface SecureStore {
	
	void create(CustomUser customeUser);
	CustomUser retrieve(String memberId);
	
}
