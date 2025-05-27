package com.data.repository;

import com.data.dto.CategoryDTO;
import com.data.model.Category;
import com.data.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public List<Category> findAll() {
        Connection conn = null;
        CallableStatement cs = null;
        List<Category> categories = null;
        try {
            conn = ConnectionDB.getConnection();
            cs = conn.prepareCall("{call get_all_categories()}");
            ResultSet rs = cs.executeQuery();
            categories = new ArrayList<Category>();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setName(rs.getString("category_name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
        return categories;
    }

    @Override
    public List<Category> findCategoryByName(String name) {
        Connection conn = null;
        CallableStatement cs = null;
        List<Category> categories = null;
        try {
            conn = ConnectionDB.getConnection();
            cs = conn.prepareCall("{call get_category_by_name(?)}");
            cs.setString(1, name);
            ResultSet rs = cs.executeQuery();
            categories = new ArrayList<Category>();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setName(rs.getString("category_name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
        return categories;
    }

    @Override
    public boolean addCategory(CategoryDTO category) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.getConnection();
            cs = conn.prepareCall("{call add_category(?,?,?)}");
            cs.setString(1, category.getName());
            cs.setString(2, category.getDescription());
            cs.setBoolean(3, category.getStatus());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
        return false;
    }

    @Override
    public boolean updateCategory(CategoryDTO category) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.getConnection();
            cs = conn.prepareCall("{call update_category(?,?,?,?)}");
            cs.setInt(1, category.getId());
            cs.setString(2, category.getName());
            cs.setString(3, category.getDescription());
            cs.setBoolean(4, category.getStatus());
            int result = cs.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
        return false;
    }

    @Override
    public boolean deleteCategory(int id) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.getConnection();
            cs = conn.prepareCall("{call delete_category(?)}");
            cs.setInt(1, id);
            int result = cs.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
        return false;
    }

    @Override
    public Category findCategoryById(int id) {
        Connection conn = null;
        CallableStatement cs = null;
        Category category = null;
        try {
            conn = ConnectionDB.getConnection();
            cs = conn.prepareCall("{call get_category_by_id(?)}");
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.close(conn, cs);
        }
        return category;
    }
}
