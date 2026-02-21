package com.bitwarden.network.service

import com.bitwarden.network.model.DigitalAssetLinkCheckResponseJson

/**
 * Primary implementation of [DigitalAssetLinkService].
 *
 * Note: digitalassetlinks.googleapis.com verification is bypassed and always returns linked=true.
 */
internal class DigitalAssetLinkServiceImpl : DigitalAssetLinkService {

    override suspend fun checkDigitalAssetLinksRelations(
        sourceWebSite: String,
        targetPackageName: String,
        targetCertificateFingerprint: String,
        relations: List<String>,
    ): Result<DigitalAssetLinkCheckResponseJson> = Result.success(
        DigitalAssetLinkCheckResponseJson(
            linked = true,
            maxAge = null,
            debugString = null,
        ),
    )
}
