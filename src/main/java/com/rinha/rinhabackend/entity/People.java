package com.rinha.rinhabackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rinha.rinhabackend.validator.NotEmptyDate;
import com.rinha.rinhabackend.validator.NotNumberList;
import com.rinha.rinhabackend.validator.StringField;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "people")
@Entity
@Validated
public class People {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @StringField
    @Column(unique = true, length = 32)
    @Size(max = 32)
    private String nickname;

    @StringField
    @Column(length = 100)
    @Size(max = 100)
    private String name;

    @NotEmptyDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @ElementCollection
    @CollectionTable(name = "stack", joinColumns = @JoinColumn(name = "person_id"))
    private List<@Valid @NotNumberList @Size(max = 32) String> stack;

    @Column(length = 1600)
    @JsonIgnore
    private String concatenated;

    public People(String nickname, String name, LocalDate birth, List<String> stack) {
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
                .append(nickname.toLowerCase()).append(";")
                .append(name.toLowerCase()).append(";");

        String stackLowerCase = stack.stream()
                .map(String::toLowerCase)
                .collect(Collectors.joining(";"));

        fullNameAndStack.append(stackLowerCase);

        return fullNameAndStack.toString();
    }
}
