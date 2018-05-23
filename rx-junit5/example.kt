@ExtendWith(value = [MockitoExtension::class, RxExtension::class])
class ExampleUnitTest() {

    @Mock
    private lateinit var provider: MyProvider

    @Mock
    private lateinit var controlled: MyControlled

    @InjectMocks
    private lateinit var stuv: ClassToTest

    @Test
    @DisplayName("Rx work as excepted in unit tests")
    fun doATest() {
        // given
        given(provider.getIt()).willReturn(Single.just("The value"))

        // when
        stuv.doThings() // Please assume that "stuv" will call "controlled" after "providere" send an Rx event.

        // then
        then(controlled).should().updateWith("The value")
    }

}