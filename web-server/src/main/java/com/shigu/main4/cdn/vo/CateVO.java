package com.shigu.main4.cdn.vo;

/**
 * 市场中档口的经营类目
 * Created by zhaohongbo on 17/3/25.
 */
public class CateVO {
    /**
     * 类目ID
     */
    private Long id;

    private String name;

    public CateVO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CateVO cateVO = (CateVO) o;

        if (id != null ? !id.equals(cateVO.id) : cateVO.id != null) return false;
        return !(name != null ? !name.equals(cateVO.name) : cateVO.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
