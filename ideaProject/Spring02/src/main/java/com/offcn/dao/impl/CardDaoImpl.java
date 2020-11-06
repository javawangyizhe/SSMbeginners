package com.offcn.dao.impl;

import com.offcn.dao.CardDao;
import com.offcn.pojo.Card;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository()
public class CardDaoImpl  implements CardDao {

    /*//private JdbcTemplate jdbcTemplate;
    private QueryRunner queryRunner;

    public QueryRunner getQueryRunner() {
        return queryRunner;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }*/
    @Value("张三")
    private String name;

    @Override
    public Card findCardById(Integer id) {
        /*try {
            Card card = queryRunner.query("select * from card where id = ?",
                    new BeanHandler<>(Card.class), 1);
            return card;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
        return null;
    }

    @Override
    public List<Card> findAllCard() {
        return null;
    }

    @Override
    public void insert(Card card) {

    }

    @Override
    public void update(Card card) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public String toString() {
        return "CardDaoImpl{" +
                "name='" + name + '\'' +
                '}';
    }
    /*    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/
}
