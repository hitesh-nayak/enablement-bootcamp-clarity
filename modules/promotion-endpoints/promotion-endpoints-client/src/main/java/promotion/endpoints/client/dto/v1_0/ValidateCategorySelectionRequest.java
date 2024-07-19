package promotion.endpoints.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import promotion.endpoints.client.function.UnsafeSupplier;
import promotion.endpoints.client.serdes.v1_0.ValidateCategorySelectionRequestSerDes;

/**
 * @author me
 * @generated
 */
@Generated("")
public class ValidateCategorySelectionRequest
	implements Cloneable, Serializable {

	public static ValidateCategorySelectionRequest toDTO(String json) {
		return ValidateCategorySelectionRequestSerDes.toDTO(json);
	}

	public Long getFirstCategory() {
		return firstCategory;
	}

	public void setFirstCategory(Long firstCategory) {
		this.firstCategory = firstCategory;
	}

	public void setFirstCategory(
		UnsafeSupplier<Long, Exception> firstCategoryUnsafeSupplier) {

		try {
			firstCategory = firstCategoryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long firstCategory;

	public Long getFourthCategory() {
		return fourthCategory;
	}

	public void setFourthCategory(Long fourthCategory) {
		this.fourthCategory = fourthCategory;
	}

	public void setFourthCategory(
		UnsafeSupplier<Long, Exception> fourthCategoryUnsafeSupplier) {

		try {
			fourthCategory = fourthCategoryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long fourthCategory;

	public Long getRootCategory() {
		return rootCategory;
	}

	public void setRootCategory(Long rootCategory) {
		this.rootCategory = rootCategory;
	}

	public void setRootCategory(
		UnsafeSupplier<Long, Exception> rootCategoryUnsafeSupplier) {

		try {
			rootCategory = rootCategoryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long rootCategory;

	public Long getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(Long secondCategory) {
		this.secondCategory = secondCategory;
	}

	public void setSecondCategory(
		UnsafeSupplier<Long, Exception> secondCategoryUnsafeSupplier) {

		try {
			secondCategory = secondCategoryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long secondCategory;

	public Long getThirdCategory() {
		return thirdCategory;
	}

	public void setThirdCategory(Long thirdCategory) {
		this.thirdCategory = thirdCategory;
	}

	public void setThirdCategory(
		UnsafeSupplier<Long, Exception> thirdCategoryUnsafeSupplier) {

		try {
			thirdCategory = thirdCategoryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long thirdCategory;

	@Override
	public ValidateCategorySelectionRequest clone()
		throws CloneNotSupportedException {

		return (ValidateCategorySelectionRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ValidateCategorySelectionRequest)) {
			return false;
		}

		ValidateCategorySelectionRequest validateCategorySelectionRequest =
			(ValidateCategorySelectionRequest)object;

		return Objects.equals(
			toString(), validateCategorySelectionRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ValidateCategorySelectionRequestSerDes.toJSON(this);
	}

}