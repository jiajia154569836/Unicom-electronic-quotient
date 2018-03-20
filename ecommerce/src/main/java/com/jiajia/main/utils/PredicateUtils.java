/**
 * Copyright (c) 2018 www.bonc.com.cn. All Rights Reserved.
 */
package com.jiajia.main.utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

/**
 * 描述当前功能
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
public class PredicateUtils {

    public static Predicate merge(CriteriaBuilder cb, Predicate... predicates) {
        if (predicates.length == 0) {
            return null;
        } else if (predicates.length == 1) {
            return predicates[0];
        } else if (predicates.length == 2) {
            Predicate p1 = predicates[0];
            Predicate p2 = predicates[1];
            return p1 == null ? (p2 == null ? null : p2) : (p2 == null ? p1 : cb.and(p1, p2));
        } else {
            Predicate[] ps = new Predicate[predicates.length - 1];
            ps[0] = merge(cb, predicates[0], predicates[1]);

            for (int i = 0; i < ps.length - 1; i++) {
                ps[i + 1] = predicates[i + 2];
            }
            return merge(cb, ps);
        }
    }

}
