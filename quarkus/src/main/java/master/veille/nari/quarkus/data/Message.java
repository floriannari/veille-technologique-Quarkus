package master.veille.nari.quarkus.data;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "messages", indexes = { @Index(columnList = Message.USER_COLUMN_NAME, unique = false),
		@Index(columnList = Message.DATE_COLUMN_NAME, unique = false) })
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Message extends PanacheEntity {
	static final String USER_COLUMN_NAME = "user_id";
	static final String DATE_COLUMN_NAME = "date";

	@NonNull
	@ManyToOne(optional = false)
	@JoinColumn(name = USER_COLUMN_NAME, updatable = false, nullable = false)
	private User user;

	@NonNull
	@Column(updatable = false, nullable = false)
	private String message;

	@Column(name = DATE_COLUMN_NAME, updatable = false, nullable = false)
	@CreationTimestamp
	private Timestamp date;

	public static List<Message> listByUser(User user) {
		return list(USER_COLUMN_NAME, SORT_BY_DATE, user);
	}

	public static List<Message> listOrderedByDate() {
		return findAll(SORT_BY_DATE).list();
	}

	private static final Sort SORT_BY_DATE = Sort.by(DATE_COLUMN_NAME);
}
