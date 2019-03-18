/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jugvale.crud.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.jugvale.crud.model.Encontro;

/**
 *
 */
@ApplicationScoped
public class EncontroServiceImpl implements EncontroService {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Encontro> lista() {
        return em.createQuery("select e from Encontro e", Encontro.class).getResultList();
    }

    @Override
    @Transactional
    public long cria(Encontro encontro) {
        em.persist(encontro);
        return encontro.getId();
    }

    @Override
    public Encontro porId(long id) {
        return em.find(Encontro.class, id);
    }

    @Override
    @Transactional
    public void apagar(long id) {
        Encontro encontro = porId(id);
        em.remove(encontro);
    }

}
