package com.hrms.hrms.businnes.abstracts;

import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	Result add(VerificationCode code);
}
