package com.bitwarden.network.service

import com.bitwarden.core.data.util.asSuccess
import com.bitwarden.network.base.BaseServiceTest
import com.bitwarden.network.model.DigitalAssetLinkCheckResponseJson
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DigitalAssetLinkServiceTest : BaseServiceTest() {
    private val digitalAssetLinkService: DigitalAssetLinkService = DigitalAssetLinkServiceImpl()

    @Test
    fun `checkDigitalAssetLinksRelations should always return linked=true without network call`() =
        runTest {
            assertEquals(
                DigitalAssetLinkCheckResponseJson(
                    linked = true,
                    maxAge = null,
                    debugString = null,
                )
                    .asSuccess(),
                digitalAssetLinkService.checkDigitalAssetLinksRelations(
                    sourceWebSite = "https://www.bitwarden.com",
                    targetPackageName = "com.x8bit.bitwarden",
                    targetCertificateFingerprint =
                        "00:01:02:03:04:05:06:07:08:09:0A:0B:0C:0D:0E:0F:10:11:12:13",
                    relations = listOf("delegate_permission/common.handle_all_urls"),
                ),
            )
        }
}
