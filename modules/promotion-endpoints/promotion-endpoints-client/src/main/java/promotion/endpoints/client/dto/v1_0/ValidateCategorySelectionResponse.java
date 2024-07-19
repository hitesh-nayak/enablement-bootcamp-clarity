package promotion.endpoints.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import promotion.endpoints.client.function.UnsafeSupplier;
import promotion.endpoints.client.serdes.v1_0.ValidateCategorySelectionResponseSerDes;

/**
 * @author me
 * @generated
 */
@Generated("")
public class ValidateCategorySelectionResponse
	implements Cloneable, Serializable {

	public static ValidateCategorySelectionResponse toDTO(String json) {
		return ValidateCategorySelectionResponseSerDes.toDTO(json);
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public void setIsValid(
		UnsafeSupplier<Boolean, Exception> isValidUnsafeSupplier) {

		try {
			isValid = isValidUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isValid;

	@Override
	public ValidateCategorySelectionResponse clone()
		throws CloneNotSupportedException {

		return (ValidateCategorySelectionResponse)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ValidateCategorySelectionResponse)) {
			return false;
		}

		ValidateCategorySelectionResponse validateCategorySelectionResponse =
			(ValidateCategorySelectionResponse)object;

		return Objects.equals(
			toString(), validateCategorySelectionResponse.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ValidateCategorySelectionResponseSerDes.toJSON(this);
	}

}