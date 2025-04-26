package com.hms.HMSApplication.entity;

import com.hms.HMSApplication.dto.enumlist.ProofTypeDocument;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@Table(name = "proof_submitted")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProofSubmitted {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "proof_submitted_id", nullable = false)
    private UUID proofSubmittedId;
    private String proofName;
    private ProofTypeDocument proofTypeDocument;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "proof_submitted_id")
    private List<ImageDetails> proofImages;


}