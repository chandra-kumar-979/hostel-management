package com.hms.HMSApplication.dto;

import com.hms.HMSApplication.dto.enumlist.ProofTypeDocument;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.hms.HMSApplication.entity.ProofSubmitted} entity
 */
@Data
public class ProofSubmittedDto implements Serializable {
    private final UUID proofSubmittedId;
    private final String proofName;
    private final ProofTypeDocument proofTypeDocument;
    private final List<ImageDetailsDto> proofImages;
}