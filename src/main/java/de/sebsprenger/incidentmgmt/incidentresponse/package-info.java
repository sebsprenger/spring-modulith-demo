@ApplicationModule(
        id = Constants.INCIDENT_RESPONSE,
        displayName = "Incident Response",
        allowedDependencies = {
                Constants.USER,
                Constants.USER_NAMED_INTERFACES
        }
)
package de.sebsprenger.incidentmgmt.incidentresponse;

import de.sebsprenger.incidentmgmt.Constants;
import org.springframework.modulith.ApplicationModule;