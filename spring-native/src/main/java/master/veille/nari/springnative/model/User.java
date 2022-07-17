package master.veille.nari.springnative.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "users", indexes = @Index(columnList = User.USERNAME_COLUMN_NAME, unique = true))
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
	static final String USERNAME_COLUMN_NAME = "username";

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;
	
	@NonNull
	@Column(name = USERNAME_COLUMN_NAME, unique = true, updatable = false, nullable = false)
	private String username;
}

