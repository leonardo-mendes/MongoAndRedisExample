package com.cvortex.eventconfig.domain.loadAppDomain;

import com.cvortex.eventconfig.domain.Application;
import com.cvortex.eventconfig.domain.EventType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class LoadApplication implements Serializable {

    private Application application;

    private List<EventType> eventTypes;

}
