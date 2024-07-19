package promotion.endpoints.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import promotion.endpoints.client.function.UnsafeSupplier;
import promotion.endpoints.client.serdes.v1_0.PromotionCategorySerDes;

/**
 * @author me
 * @generated
 */
@Generated("")
public class PromotionCategory implements Cloneable, Serializable {

	public static PromotionCategory toDTO(String json) {
		return PromotionCategorySerDes.toDTO(json);
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryId(
		UnsafeSupplier<Long, Exception> categoryIdUnsafeSupplier) {

		try {
			categoryId = categoryIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long categoryId;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setDesc(UnsafeSupplier<String, Exception> descUnsafeSupplier) {
		try {
			desc = descUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String desc;

	public Boolean getHasSubCategories() {
		return hasSubCategories;
	}

	public void setHasSubCategories(Boolean hasSubCategories) {
		this.hasSubCategories = hasSubCategories;
	}

	public void setHasSubCategories(
		UnsafeSupplier<Boolean, Exception> hasSubCategoriesUnsafeSupplier) {

		try {
			hasSubCategories = hasSubCategoriesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean hasSubCategories;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	public Long[] getSubCategoriesIds() {
		return subCategoriesIds;
	}

	public void setSubCategoriesIds(Long[] subCategoriesIds) {
		this.subCategoriesIds = subCategoriesIds;
	}

	public void setSubCategoriesIds(
		UnsafeSupplier<Long[], Exception> subCategoriesIdsUnsafeSupplier) {

		try {
			subCategoriesIds = subCategoriesIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long[] subCategoriesIds;

	public Number getSuperCategoryId() {
		return superCategoryId;
	}

	public void setSuperCategoryId(Number superCategoryId) {
		this.superCategoryId = superCategoryId;
	}

	public void setSuperCategoryId(
		UnsafeSupplier<Number, Exception> superCategoryIdUnsafeSupplier) {

		try {
			superCategoryId = superCategoryIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Number superCategoryId;

	@Override
	public PromotionCategory clone() throws CloneNotSupportedException {
		return (PromotionCategory)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PromotionCategory)) {
			return false;
		}

		PromotionCategory promotionCategory = (PromotionCategory)object;

		return Objects.equals(toString(), promotionCategory.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PromotionCategorySerDes.toJSON(this);
	}

}