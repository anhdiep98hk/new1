/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CategoryProductDAO;
import entity.Categories;
import entity.Products;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author exam
 */
@ManagedBean
@RequestScoped
public class CatProBean {

    /**
     * Creates a new instance of CatProBean
     */
    private List<Categories> listCate;
    private List<Products> listPro;
    
    public CatProBean() {
        listCate = new CategoryProductDAO().getAllCategories();
    }
    
    public String productDetail(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> map = fc.getExternalContext().getRequestParameterMap();
        
        String cId = map.get("cateId");
        listPro = new CategoryProductDAO().getProductByCategoryId(cId);
        return "detailProduct";
    }

    public List<Categories> getListCate() {
        return listCate;
    }

    public void setListCate(List<Categories> listCate) {
        this.listCate = listCate;
    }

    public List<Products> getListPro() {
        return listPro;
    }

    public void setListPro(List<Products> listPro) {
        this.listPro = listPro;
    }
    
}
