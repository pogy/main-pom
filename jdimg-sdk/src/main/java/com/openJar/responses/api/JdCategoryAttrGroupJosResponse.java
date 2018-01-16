package com.openJar.responses.api;



import com.openJar.responses.Response;
import java.util.Set;

/**
 * Created By admin on 2017/12/14/16:18
 */
public class JdCategoryAttrGroupJosResponse extends Response {

    private Long groupId;
    private String groupName;
    private Integer attrGroupIndexId;
    private Set<JdFeatureCateAttrGroupJosResponse> attrGroupfeatures;

    public JdCategoryAttrGroupJosResponse() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getAttrGroupIndexId() {
        return attrGroupIndexId;
    }

    public void setAttrGroupIndexId(Integer attrGroupIndexId) {
        this.attrGroupIndexId = attrGroupIndexId;
    }

    public Set<JdFeatureCateAttrGroupJosResponse> getAttrGroupfeatures() {
        return attrGroupfeatures;
    }

    public void setAttrGroupfeatures(Set<JdFeatureCateAttrGroupJosResponse> attrGroupfeatures) {
        this.attrGroupfeatures = attrGroupfeatures;
    }
}
