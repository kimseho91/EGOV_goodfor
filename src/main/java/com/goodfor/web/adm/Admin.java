package com.goodfor.web.adm;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Lazy
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	private String aid, apw, aname, anum, arank, email, phonenum, test2;
}
