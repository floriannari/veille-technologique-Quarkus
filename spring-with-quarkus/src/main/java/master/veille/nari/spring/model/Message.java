package master.veille.nari.spring.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
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
public class Message {
	static final String USER_COLUMN_NAME = "user_id";
	static final String DATE_COLUMN_NAME = "date";

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;

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
}
