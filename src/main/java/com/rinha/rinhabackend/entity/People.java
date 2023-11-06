package com.rinha.rinhabackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rinha.rinhabackend.validator.NotEmptyDate;
import com.rinha.rinhabackend.validator.StringField;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "people")
@Entity
public class People {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @StringField
    @Column(unique = true)
    @Size(max = 32)
    private String nickname;

    @StringField
    @Size(max = 100)
    private String name;

    @NotEmptyDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @ElementCollection
    @CollectionTable(name = "stack", joinColumns = @JoinColumn(name = "person_id"))
    private List<@Valid @Size(max = 32) String> stack;

    @Column(length = 1600)
    private String concatenated;

    public People(String nickname, String name, Date birth, List<String> stack) {
        this.nickname = nickname;
        this.name = name;
        this.birth = birth;
        this.stack = stack;
        this.concatenated = getFullNameAndStack();
    }

    @Transient
    @JsonIgnore
    private String getFullNameAndStack() {
        StringBuilder fullNameAndStack = new StringBuilder();

        fullNameAndStack
                .append(nickname).append(";")
                .append(name).append(";")
                .append(String.join(";", stack));

        return fullNameAndStack.toString();
    }
}
