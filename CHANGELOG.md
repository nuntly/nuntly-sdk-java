# Changelog

## 0.5.0 (2026-03-24)

Full Changelog: [v0.4.0...v0.5.0](https://github.com/nuntly/nuntly-sdk-java/compare/v0.4.0...v0.5.0)

### Features

* **api:** add sending status 'paused' for the domain ([948ddf3](https://github.com/nuntly/nuntly-sdk-java/commit/948ddf3ed661fe3d765ee45dae94d7732c1fc7b6))


### Bug Fixes

* **client:** allow updating header/query affecting fields in `toBuilder()` ([1945d7e](https://github.com/nuntly/nuntly-sdk-java/commit/1945d7e01683487fbecd49f1b8f152907f9a4063))


### Chores

* **internal:** bump ktfmt ([834f03e](https://github.com/nuntly/nuntly-sdk-java/commit/834f03e449b575b009bb0d27d2f22e8a66f1111b))
* **internal:** tweak CI branches ([49c00ef](https://github.com/nuntly/nuntly-sdk-java/commit/49c00ef7c9adfcd0c0eea6344bf1503d7bfb3486))
* **internal:** update gitignore ([5dc3500](https://github.com/nuntly/nuntly-sdk-java/commit/5dc3500e8d21ea49fe056af191b3d5dce01a02fc))
* **internal:** update retry delay tests ([e9cf065](https://github.com/nuntly/nuntly-sdk-java/commit/e9cf0650b6b478a3ca419253e05d0b2b20f2c925))
* **tests:** bump steady to v0.19.4 ([dbd935e](https://github.com/nuntly/nuntly-sdk-java/commit/dbd935ec61d8216c26c25dc3dc5f0077d522d58a))
* **tests:** bump steady to v0.19.5 ([32841f7](https://github.com/nuntly/nuntly-sdk-java/commit/32841f7315c07c9e881e2b6aabd13cce7b305ff2))
* **tests:** bump steady to v0.19.6 ([4b309ef](https://github.com/nuntly/nuntly-sdk-java/commit/4b309ef00d759fcd98404a741abfb378d4fb154c))


### Refactors

* **tests:** switch from prism to steady ([9a4ba28](https://github.com/nuntly/nuntly-sdk-java/commit/9a4ba28adee426a8a2c1887f244072c7c2c10934))

## 0.4.0 (2026-03-16)

Full Changelog: [v0.3.0...v0.4.0](https://github.com/nuntly/nuntly-sdk-java/compare/v0.3.0...v0.4.0)

### ⚠ BREAKING CHANGES

* **api:** rename template "context" field to "variables"

### Features

* **api:** add webhook signature verification ([784b49b](https://github.com/nuntly/nuntly-sdk-java/commit/784b49bf39145b307c48da3fdea40f77b4a0c344))
* **api:** config update for obazoud/dev ([2287287](https://github.com/nuntly/nuntly-sdk-java/commit/228728703999328d30933ef425d9397872aacb51))
* **api:** inbound email ([b5ee818](https://github.com/nuntly/nuntly-sdk-java/commit/b5ee818f0f5a04b1b398f3beebb36c497a2b4e0e))
* **api:** manual updates ([9a51a9f](https://github.com/nuntly/nuntly-sdk-java/commit/9a51a9f6a32bb37d5b2574fd0f283a7f8e61f705))
* **api:** manual updates ([856589c](https://github.com/nuntly/nuntly-sdk-java/commit/856589c8fd9278a41855d9cf29f1b570cdc74779))
* **api:** Move EmailHeaders in shared ([b420f5c](https://github.com/nuntly/nuntly-sdk-java/commit/b420f5cd739ca8fbb3d4109aa8680e55c21c0622))
* **api:** prepare the next version of the API ([ba42466](https://github.com/nuntly/nuntly-sdk-java/commit/ba42466c7ad2f6724c2384c658dcd001089ace86))
* **api:** rename retry to replay ([e295c3a](https://github.com/nuntly/nuntly-sdk-java/commit/e295c3ab9e13712ede33787d1f536d97acdcde0f))
* **api:** rotate webhook signing secret ([f58af50](https://github.com/nuntly/nuntly-sdk-java/commit/f58af50178dea5f14c17913d38632f9ee1c49a38))
* **api:** webhook events, retry and deliveries ([84fad04](https://github.com/nuntly/nuntly-sdk-java/commit/84fad040680615efe58a5803a7ac23185b49f002))
* **client:** add connection pooling option ([66b5e50](https://github.com/nuntly/nuntly-sdk-java/commit/66b5e50d29764b695e09e550c0340010ae552b9d))
* **client:** expose sleeper option ([2500e45](https://github.com/nuntly/nuntly-sdk-java/commit/2500e452729d298249a260b5c0864e947e74e342))


### Bug Fixes

* **client:** deserialization of empty objects ([16224a8](https://github.com/nuntly/nuntly-sdk-java/commit/16224a8645365fb447dbc9ba19f205477bc0e060))
* **client:** ensure single timer is created per client ([2500e45](https://github.com/nuntly/nuntly-sdk-java/commit/2500e452729d298249a260b5c0864e947e74e342))
* **client:** incorrect `getPackageVersion` impl ([a1caba1](https://github.com/nuntly/nuntly-sdk-java/commit/a1caba15908cc1f4736e5e6ddee39ab7dbc0738a))
* **client:** incorrect `Retry-After` parsing ([19f84ef](https://github.com/nuntly/nuntly-sdk-java/commit/19f84ef5a85076a6d2cb1365903ba8a8e4962077))
* **client:** multi-value header serialization ([fe5e7b4](https://github.com/nuntly/nuntly-sdk-java/commit/fe5e7b4e87d0df3ed144f6f02fdb14e6ee52bd42))


### Chores

* **ci:** skip uploading artifacts on stainless-internal branches ([16fdfca](https://github.com/nuntly/nuntly-sdk-java/commit/16fdfca802783adb99944d77bee97cf90041e5c1))
* configure new SDK language ([b7ac23b](https://github.com/nuntly/nuntly-sdk-java/commit/b7ac23b4d084a55623a36881e96a1b9f1c551ad4))
* drop apache dependency ([d8922df](https://github.com/nuntly/nuntly-sdk-java/commit/d8922df835d28311f32fa9f52832708873fcb1de))
* improve example values ([b3b0a61](https://github.com/nuntly/nuntly-sdk-java/commit/b3b0a61fddafe48f08c8c28ff8c8308f60164c58))
* improve formatter performance ([871d0ca](https://github.com/nuntly/nuntly-sdk-java/commit/871d0caed79a8aa74508a2370b63df2bbb7f2b31))
* improve formatter performance ([d595019](https://github.com/nuntly/nuntly-sdk-java/commit/d595019c6c10b4c8d9b9a9517caf398b5857e083))
* **internal:** allow passing args to `./scripts/test` ([3b520fc](https://github.com/nuntly/nuntly-sdk-java/commit/3b520fc0c72bbcc256e404f12aba7e68424d5a90))
* **internal:** bump palantir-java-format ([80e8b2a](https://github.com/nuntly/nuntly-sdk-java/commit/80e8b2abbca708ce8b87b712288d00b6f040923e))
* **internal:** codegen related update ([3f1a47e](https://github.com/nuntly/nuntly-sdk-java/commit/3f1a47e118fbf824d7258822a4bd1b273850ddee))
* **internal:** codegen related update ([53f50d3](https://github.com/nuntly/nuntly-sdk-java/commit/53f50d320474b9dfafebe1d51a75c8549cf83b7c))
* **internal:** codegen related update ([e86d29e](https://github.com/nuntly/nuntly-sdk-java/commit/e86d29e3b4390731ee96b93f4b60c809eadd7042))
* **internal:** codegen related update ([c08b0fc](https://github.com/nuntly/nuntly-sdk-java/commit/c08b0fc06742787fc7f1ee694848807638001e8a))
* **internal:** codegen related update ([712e89b](https://github.com/nuntly/nuntly-sdk-java/commit/712e89be587b48ce61bf77d988970f30bb7572bd))
* **internal:** expand imports ([ce1f86e](https://github.com/nuntly/nuntly-sdk-java/commit/ce1f86e2cc2f0377ce08fed72d92809aaaa5b20f))
* **internal:** make `OkHttp` constructor internal ([02bd02a](https://github.com/nuntly/nuntly-sdk-java/commit/02bd02a68603620ac3d784e4ac2f5306db76e73c))
* **internal:** remove unnecessary base URL ([579b1b0](https://github.com/nuntly/nuntly-sdk-java/commit/579b1b0d93a3b6a07f6f197ad54740fae64d5d4a))
* **internal:** update `TestServerExtension` comment ([deabbf6](https://github.com/nuntly/nuntly-sdk-java/commit/deabbf63888f669193b8618085a0344e6035bf0f))
* **internal:** upgrade AssertJ ([453b0e0](https://github.com/nuntly/nuntly-sdk-java/commit/453b0e01ee734e1ba73a9a222fb450efe6e7ce9c))
* make `Properties` more resilient to `null` ([32b9039](https://github.com/nuntly/nuntly-sdk-java/commit/32b90394f839ae1f5326e3602e49e6528a7aabf8))
* **test:** do not count install time for mock server timeout ([58dc9ef](https://github.com/nuntly/nuntly-sdk-java/commit/58dc9ef4974e160119b192d0b05fc6e67ec07d62))
* update SDK settings ([74d4425](https://github.com/nuntly/nuntly-sdk-java/commit/74d44258da58136ea71237d4067bd2fe93100033))


### Documentation

* **client:** update readme timeout snippet ([b0b46ed](https://github.com/nuntly/nuntly-sdk-java/commit/b0b46ed7cb7cd24181a4df41435ce813fb68ecc6))


### Refactors

* **api:** rename template "context" field to "variables" ([8bfd0b5](https://github.com/nuntly/nuntly-sdk-java/commit/8bfd0b5a9d3fa38d47383539c264a80c1c319360))

## 0.3.0 (2026-01-29)

Full Changelog: [v0.2.0...v0.3.0](https://github.com/nuntly/nuntly-sdk-java/compare/v0.2.0...v0.3.0)

### Features

* **api:** rename retry to replay ([e201579](https://github.com/nuntly/nuntly-sdk-java/commit/e2015797ca8ba887b7baebdda904ee6ce7475850))


### Bug Fixes

* **client:** deserialization of empty objects ([b536710](https://github.com/nuntly/nuntly-sdk-java/commit/b536710ee560f1d149577878755687ba255ab1af))
* **client:** multi-value header serialization ([7ddcbc4](https://github.com/nuntly/nuntly-sdk-java/commit/7ddcbc4808232f776c96d8fb820f8ea823b1909a))


### Chores

* improve example values ([72db38f](https://github.com/nuntly/nuntly-sdk-java/commit/72db38f16f2ba3ab2846723cfacd80d6d9061d53))
* **internal:** codegen related update ([2fd5146](https://github.com/nuntly/nuntly-sdk-java/commit/2fd51461d20dd79594294a0c13a7437966ca794d))
* **internal:** codegen related update ([2f561d4](https://github.com/nuntly/nuntly-sdk-java/commit/2f561d462ae6e54ef092d83a52b6ba4b1947182c))


### Documentation

* **client:** update readme timeout snippet ([167194b](https://github.com/nuntly/nuntly-sdk-java/commit/167194be7834665f0a8364dc1677e759f27cae0f))

## 0.2.0 (2025-09-22)

Full Changelog: [v0.1.4...v0.2.0](https://github.com/nuntly/nuntly-sdk-java/compare/v0.1.4...v0.2.0)

### Features

* **api:** rotate webhook signing secret ([d2fc568](https://github.com/nuntly/nuntly-sdk-java/commit/d2fc56847a0d648912cc39fd946c2f764ad6eec7))
* **api:** webhook events, retry and deliveries ([26f87b3](https://github.com/nuntly/nuntly-sdk-java/commit/26f87b39c4cf8d1148880fbc80ebd3532bb7766e))
* **client:** expose sleeper option ([f69e0fa](https://github.com/nuntly/nuntly-sdk-java/commit/f69e0fa9e48c06c3bc3728eb07a883c6950ecbb0))


### Bug Fixes

* **client:** ensure single timer is created per client ([f69e0fa](https://github.com/nuntly/nuntly-sdk-java/commit/f69e0fa9e48c06c3bc3728eb07a883c6950ecbb0))


### Chores

* improve formatter performance ([bff501b](https://github.com/nuntly/nuntly-sdk-java/commit/bff501bd1f14ea58fce596b7bd6527addb21b169))

## 0.1.4 (2025-09-16)

Full Changelog: [v0.1.3...v0.1.4](https://github.com/nuntly/nuntly-sdk-java/compare/v0.1.3...v0.1.4)

### Bug Fixes

* **client:** incorrect `getPackageVersion` impl ([9e812d5](https://github.com/nuntly/nuntly-sdk-java/commit/9e812d5dac101c135bdcc78f2872d4140a5e4b2b))

## 0.1.3 (2025-09-13)

Full Changelog: [v0.1.2...v0.1.3](https://github.com/nuntly/nuntly-sdk-java/compare/v0.1.2...v0.1.3)

### Chores

* **internal:** codegen related update ([1e9bc87](https://github.com/nuntly/nuntly-sdk-java/commit/1e9bc87bbc98276f4d9890e0450f96990ea785cd))

## 0.1.2 (2025-09-12)

Full Changelog: [v0.1.1...v0.1.2](https://github.com/nuntly/nuntly-sdk-java/compare/v0.1.1...v0.1.2)

### Chores

* improve formatter performance ([65d9aa4](https://github.com/nuntly/nuntly-sdk-java/commit/65d9aa43ea3d2dfd030f4f6f4027c19a47e4577f))

## 0.1.1 (2025-09-10)

Full Changelog: [v0.1.0...v0.1.1](https://github.com/nuntly/nuntly-sdk-java/compare/v0.1.0...v0.1.1)

### Chores

* **publish:** configure to publish to Central Portal ([39b66d4](https://github.com/nuntly/nuntly-sdk-java/commit/39b66d447d96b3dd6b8b412f1fe431739865478d))

## 0.1.0 (2025-09-10)

Full Changelog: [v0.0.1...v0.1.0](https://github.com/nuntly/nuntly-sdk-java/compare/v0.0.1...v0.1.0)

### Features

* **api:** config update for obazoud/dev ([2287287](https://github.com/nuntly/nuntly-sdk-java/commit/228728703999328d30933ef425d9397872aacb51))
* **api:** Move EmailHeaders in shared ([b420f5c](https://github.com/nuntly/nuntly-sdk-java/commit/b420f5cd739ca8fbb3d4109aa8680e55c21c0622))


### Chores

* configure new SDK language ([b7ac23b](https://github.com/nuntly/nuntly-sdk-java/commit/b7ac23b4d084a55623a36881e96a1b9f1c551ad4))
* update SDK settings ([74d4425](https://github.com/nuntly/nuntly-sdk-java/commit/74d44258da58136ea71237d4067bd2fe93100033))
