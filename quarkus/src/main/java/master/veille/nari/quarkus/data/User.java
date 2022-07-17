package master.veille.nari.quarkus.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "users", indexes = @Index(columnList = User.USERNAME_COLUMN_NAME, unique = true))
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class User extends PanacheEntity {
	static final String USERNAME_COLUMN_NAME = "username";

	@NonNull
	@Column(name = USERNAME_COLUMN_NAME, unique = true, updatable = false, nullable = false)
	private String username;

	public static User findByUsername(String username) {
		return find(USERNAME_COLUMN_NAME, username).singleResult();
	}

	public static List<User> listOrderbyUsername() {
		return findAll(SORT_BY_USERNAME).list();
	}

	private static final Sort SORT_BY_USERNAME = Sort.by(USERNAME_COLUMN_NAME);
}
