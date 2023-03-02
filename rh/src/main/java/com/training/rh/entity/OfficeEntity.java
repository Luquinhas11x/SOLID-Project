package com.training.rh.entity;

public enum OfficeEntity {
    ASSISTANT {
        @Override
        public OfficeEntity getNextOffice() {
            return ANALYST;
        }
    },
    ANALYST {
        @Override
        public OfficeEntity getNextOffice() {
            return SPECIALIST;
        }
    },
    SPECIALIST {
        @Override
        public OfficeEntity getNextOffice() {
            return MANAGER;
        }
    },
    MANAGER {
        @Override
        public OfficeEntity getNextOffice() {
            return MANAGER;
        }
    };

    public abstract OfficeEntity getNextOffice();
}
